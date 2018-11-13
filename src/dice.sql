--drop tables
DROP TABLE COFFEE_DESCRIPTIONS;
DROP TABLE COFFEE_HOUSES;
DROP TABLE MERCH_INVENTORY;
DROP TABLE COF_INVENTORY;
DROP TABLE RSS_FEEDS;
DROP TABLE COFFEES;
DROP TABLE SUPPLIERS;
DROP TABLE DATA_REPOSITORY;

--create tables
create table SUPPLIERS
  (SUP_ID integer NOT NULL,
  SUP_NAME varchar(40) NOT NULL,
  STREET varchar(40) NOT NULL,
  CITY varchar(20) NOT NULL,
  STATE char(2) NOT NULL,
  ZIP char(5),
  PRIMARY KEY (SUP_ID));
create table COFFEES
  (COF_NAME varchar(32) NOT NULL,
  SUP_ID int NOT NULL,
  PRICE numeric(10,2) NOT NULL,
  SALES integer NOT NULL,
  TOTAL integer NOT NULL,
  PRIMARY KEY (COF_NAME),
  FOREIGN KEY (SUP_ID) REFERENCES SUPPLIERS (SUP_ID));
create table COFFEE_DESCRIPTIONS
  (COF_NAME varchar(32) NOT NULL,
  COF_DESC blob NOT NULL,
  PRIMARY KEY (COF_NAME),
  FOREIGN KEY (COF_NAME) REFERENCES COFFEES (COF_NAME));
create table RSS_FEEDS
  (RSS_NAME varchar(32) NOT NULL,
  RSS_FEED_XML longtext NOT NULL,
  PRIMARY KEY (RSS_NAME));
create table COFFEE_HOUSES
  (STORE_ID integer NOT NULL,
  CITY varchar(32),
  COFFEE int NOT NULL,
  MERCH int NOT NULL,
  TOTAL int NOT NULL,
  PRIMARY KEY (STORE_ID));
create table DATA_REPOSITORY
  (DOCUMENT_NAME varchar(50),
  URL varchar(200));

--insert data
insert into SUPPLIERS values(49,  'Superior Coffee', '1 Party Place', 'Mendocino', 'CA', '95460');
insert into SUPPLIERS values(101, 'Acme, Inc.', '99 Market Street', 'Groundsville', 'CA', '95199');
insert into SUPPLIERS values(150, 'The High Ground', '100 Coffee Lane', 'Meadows', 'CA', '93966');
insert into SUPPLIERS values(456, 'Restaurant Supplies, Inc.', '200 Magnolia Street', 'Meadows', 'CA', '93966');
insert into SUPPLIERS values(927, 'Professional Kitchen', '300 Daisy Avenue', 'Groundsville', 'CA', '95199');

insert into COFFEES values('Colombian',          101, 7.99, 0, 0);
insert into COFFEES values('French_Roast',       49,  8.99, 0, 0);
insert into COFFEES values('Espresso',           150, 9.99, 0, 0);
insert into COFFEES values('Colombian_Decaf',    101, 8.99, 0, 0);
insert into COFFEES values('French_Roast_Decaf', 049, 9.99, 0, 0);

insert into COFFEE_HOUSES values(10023, 'Mendocino', 3450, 2005, 5455);
insert into COFFEE_HOUSES values(33002, 'Seattle', 4699, 3109, 7808);
insert into COFFEE_HOUSES values(10040, 'SF', 5386, 2841, 8227);
insert into COFFEE_HOUSES values(32001, 'Portland', 3147, 3579, 6726);
insert into COFFEE_HOUSES values(10042, 'SF', 2863, 1874, 4710);
insert into COFFEE_HOUSES values(10024, 'Sacramento', 1987, 2341, 4328);
insert into COFFEE_HOUSES values(10039, 'Carmel', 2691, 1121, 3812);
insert into COFFEE_HOUSES values(10041, 'LA', 1533, 1007, 2540);
insert into COFFEE_HOUSES values(33005, 'Olympia', 2733, 1550, 4283);
insert into COFFEE_HOUSES values(33010, 'Seattle', 3210, 2177, 5387);
insert into COFFEE_HOUSES values(10035, 'SF', 1922, 1056, 2978);
insert into COFFEE_HOUSES values(10037, 'LA', 2143, 1876, 4019);
insert into COFFEE_HOUSES values(10034, 'San_Jose', 1234, 1032, 2266);
insert into COFFEE_HOUSES values(32004, 'Eugene', 1356, 1112, 2468);

--selects

-- SHOW_SUPPLIERS
    select SUPPLIERS.SUP_NAME, COFFEES.COF_NAME
    from SUPPLIERS, COFFEES
    where SUPPLIERS.SUP_ID = COFFEES.SUP_ID
    order by SUP_NAME;


-- GET_SUPPLIER_OF_COFFEE
    select DISTINCT SUPPLIERS.SUP_NAME
      from SUPPLIERS, COFFEES
      where SUPPLIERS.SUP_ID = COFFEES.SUP_ID order by SUPPLIERS.SUP_NAME ASC

  select * from SUPPLIERS
