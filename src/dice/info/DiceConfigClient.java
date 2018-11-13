package dice.info;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class DiceConfigClient extends JFrame
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;

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
						DiceConfigClient frame = new DiceConfigClient();
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
	public DiceConfigClient() {
		setTitle("D.I.C.E. Configuration Client");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JToolBar toolBar = new JToolBar();
		contentPane.add(toolBar, BorderLayout.NORTH);

		

		btnNewButton_1 = new JButton("store");
		btnNewButton_1.setEnabled(true);
		btnNewButton_1.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent arg0)
				{
					try
					{
						((PropsTableModel)table.getModel()).storeData();
					}
					catch (Exception e)
					{
						e.printStackTrace();
					}
				}
			});
		toolBar.add(btnNewButton_1);
		
		btnNewButton = new JButton("add");
		btnNewButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent arg0)
				{
					try
					{
						((PropsTableModel)table.getModel()).add();
					}
					catch (Exception e)
					{
						e.printStackTrace();
					}
				}
			});
		toolBar.add(btnNewButton);
		
		btnNewButton_2 = new JButton("delete");
		btnNewButton_2.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent arg0)
				{
					try
					{
						((PropsTableModel)table.getModel()).delete();
					}
					catch (Exception e)
					{
						e.printStackTrace();
					}
				}
			});
		toolBar.add(btnNewButton_2);

		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		/*TableModel dataModel = new AbstractTableModel() {
	          public int getColumnCount() { return 2; }
	          public int getRowCount() { return 10;}
	          public Object getValueAt(int row, int col) { return new Integer(row*col); }
	      };*/
		PropsTableModel model = new PropsTableModel();
        table = new JTable(model);
        model.setTable(table);
		scrollPane.setViewportView(table);
		model.loadData();
	}
	

}

class PropsTableModel extends AbstractTableModel 
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String[] columnNames = {"key","value"};
    private Properties data = new Properties();
    private JTable table=null;
    

    public void setTable(JTable table)
    {
		this.table=table;
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		table.setModel(this);
			//	table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			final int width=640/3;
			//System.err.println(width);
		table.getColumnModel().getColumn(0).setPreferredWidth(width);
		table.getColumnModel().getColumn(0).setMinWidth(width);
		table.getColumnModel().getColumn(0).setMaxWidth(width);
	table.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
	
        
	}
    public void loadData()
    {
    	try{
    		FileInputStream in = new FileInputStream(System.getProperty("user.home")+System.getProperty("file.separator")+"dice.properties");
    		data.load(in);
    		in.close();
    		}
    	catch(Exception e) {e.printStackTrace();}

    	fireTableDataChanged();

    }
public void add()
{
	data.setProperty("newproperties"+java.lang.System.nanoTime(),"n/a");
	fireTableDataChanged();
}
public void delete()
{
	int[] selection = table.getSelectedRows();
   for (int i = 0; i < selection.length; i++) {
     selection[i] = table.convertRowIndexToModel(selection[i]);
     String key=(String)data.keySet().toArray()[selection[i]];
	 data.remove(key);
   }
  
	fireTableDataChanged();
}
public void storeData()
    {
	try
	{
		data.store(new FileOutputStream(System.getProperty("user.home")+System.getProperty("file.separator")+"dice.properties"),"");
    }
	catch(Exception e) {e.printStackTrace();}
}

public int getColumnCount() {
        return columnNames.length;
    }
 public String getColumnName(int col) {
        return columnNames[col];
    }
   public Object getValueAt(int row, int col) 
   {
	   if(col==0)
        return data.keySet().toArray()[row];
        else
         return data.getProperty((String)data.keySet().toArray()[row]);
    }


 public int getRowCount() {
        return data.size();
    }

 public boolean isCellEditable(int row, int col) 
 {
	 return true;
 }
 public void setValueAt(Object value, int row, int col)
   {
	   String key=(String)data.keySet().toArray()[row];
	   String val="";
	   
        if(col==0){
			val=data.getProperty(key);
         data.remove(key);
         data.put(value.toString(),val);
        }
        if(col==1)
        {
			data.setProperty(key,value.toString());
		}
		fireTableDataChanged();
   }

}
