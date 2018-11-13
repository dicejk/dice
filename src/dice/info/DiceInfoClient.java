package dice.info;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.JToolBar; 
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.rmi.Naming;
import java.rmi.RemoteException;

public class DiceInfoClient extends JFrame implements DiceSqlListener
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTree tree;
	private DefaultMutableTreeNode currentNode;
	private JCheckBox chckbxNewCheckBox;
	private DiceServer server;
	private DiceListener listener;
	private JButton btnNewButton;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{

		EventQueue.invokeLater(new Runnable()
			{
				public void run()
				{
					try
					{
						DiceInfoClient frame = new DiceInfoClient();
						frame.setVisible(true);
					}
					catch (Exception e)
					{
						e.printStackTrace();
					}
				}
			});
	}

	/**
	 * Create the frame.
	 */
	public DiceInfoClient() {
		setTitle("D.I.C.E. Information Client");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JToolBar toolBar = new JToolBar();
		contentPane.add(toolBar, BorderLayout.NORTH);

		btnNewButton = new JButton("connect");
		btnNewButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent arg0)
				{
					try
					{
						String registryURL = "rmi://localhost:1099/dice";
						server = (DiceServer) Naming
								.lookup(registryURL);
						listener = new DiceListenerImpl(DiceInfoClient.this);
						server.addDiceListener(listener);
						btnNewButton_1.setEnabled(true);
						btnNewButton.setEnabled(false);
					}
					catch (Exception e)
					{
						e.printStackTrace();
					}
				}
			});
		toolBar.add(btnNewButton);

		btnNewButton_1 = new JButton("disconnect");
		btnNewButton_1.setEnabled(false);
		btnNewButton_1.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent arg0)
				{
					try
					{
						server.removeDiceListener(listener);
						btnNewButton_1.setEnabled(false);
						btnNewButton.setEnabled(true);
					}
					catch (RemoteException e)
					{
						e.printStackTrace();
					}
				}
			});
		toolBar.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("clear");
		btnNewButton_2.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent arg0)
				{
					DefaultTreeModel model = (DefaultTreeModel)tree.getModel();
					DefaultMutableTreeNode root = (DefaultMutableTreeNode)model.getRoot();
					for(int i = 0; i <  root.getChildCount();i++)
					{
						model.removeNodeFromParent((DefaultMutableTreeNode)root.getChildAt(i));
					}
					currentNode = root;
				}
			});
		toolBar.add(btnNewButton_2);

		chckbxNewCheckBox = new JCheckBox("expand");
		chckbxNewCheckBox.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent arg0)
				{
					if (chckbxNewCheckBox.isSelected())
					{
						DiceInfoClient.this.expandAll(tree);
					}
					else
					{
						DiceInfoClient.this.expandRoot(tree);
					}
				}
			});
		toolBar.add(chckbxNewCheckBox);

		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);

		initTree();
		scrollPane.setViewportView(tree);
	}

	private void initTree()
	{
		currentNode = new DefaultMutableTreeNode("D.I.C.E. :");
		tree = new JTree(currentNode);
		tree.setExpandsSelectedPaths(true);
		DefaultTreeCellRenderer renderer = (DefaultTreeCellRenderer) tree
				.getCellRenderer();
		renderer.setLeafIcon(null);
		renderer.setOpenIcon(null);
		renderer.setClosedIcon(null);
		renderer.setIcon(null);
	}

	@Override
	public void sqlString(String sqlString)
	{
		DefaultTreeModel model = (DefaultTreeModel) tree.getModel();
		if (sqlString.startsWith("SQL Statement (plaintext)") || sqlString.startsWith("Connection"))
		{
			currentNode = (DefaultMutableTreeNode) model.getRoot();
			model.insertNodeInto(new DefaultMutableTreeNode(sqlString),
					currentNode, currentNode.getChildCount());
			currentNode = currentNode.getLastLeaf();
		}
		else if (sqlString.startsWith("SQL Statement (ciphered)"))
		{
			model.insertNodeInto(new DefaultMutableTreeNode(sqlString),
					currentNode, currentNode.getChildCount());
		}
		else if (sqlString.startsWith("BEGIN RESULT"))
		{
			if (currentNode.getUserObject().toString().startsWith("Result"))
			{
				currentNode = (DefaultMutableTreeNode) currentNode.getParent();
			}
			DefaultMutableTreeNode resultNode = new DefaultMutableTreeNode("Result Row "+(currentNode.getChildCount()-1));
			model.insertNodeInto(resultNode,currentNode, currentNode.getChildCount());
			currentNode = currentNode.getLastLeaf();
		}
		else
		{
			model.insertNodeInto(new DefaultMutableTreeNode(sqlString),
					currentNode, currentNode.getChildCount());
		}

		if (this.chckbxNewCheckBox.isSelected())
		{
			expandAll(tree);
		}
		else
		{
			expandRoot(tree);
		}

	}

	public void expandAll(JTree tree)
	{
		int row = 0;
		while (row < tree.getRowCount())
		{
			tree.expandRow(row);
			row++;
		}
	}

	public void expandRoot(JTree tree)
	{
		int row = 0;
		while (row < tree.getRowCount())
		{
			if (row < 1)
			{
				tree.expandRow(row);
			}
			else
			{
				tree.collapseRow(row);
			}
			row++;
		}
	}

}
