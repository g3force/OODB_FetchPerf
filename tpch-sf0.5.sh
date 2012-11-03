#!/bin/sh

echo "This script will modify your customer.ctl and orders.ctl files! Backup them, if you would like to keep them"
echo "Press Enter to confirm"
read nothing

cd ~/tpch

cuDate="`date +%s`"
mv customer.ctl customer.ctl.bak$cuDate
echo "load data
infile 'customer.tbl'
truncate into table customer
fields terminated by '|'
(
c_custkey, c_name, c_address, c_nationkey, c_phone, c_acctbal, c_mktsegment, c_comment)" > customer.ctl

mv orders.ctl orders.ctl.bak$cuDate
echo "load data
infile 'orders.tbl'
truncate into table orders
fields terminated by '|'
(
o_orderkey, o_custkey, o_orderstatus, o_totalprice, o_orderdate, o_orderpriority, o_clerk, o_shippriority, o_comment)" > orders.ctl

# environment vars, especially for date types in order
. ./env.sh
set -e

echo "Starting dbgen"
cd ../tpch-dbgen
./dbgen -fF -T c -s 0.5
./dbgen -fF -T O -s 0.5

mv customer.tbl ../tpch
mv orders.tbl ../tpch

echo "Starting sqlldr"
cd ../tpch
sqlldr tpch/tpch control=customer.ctl
sqlldr tpch/tpch control=orders.ctl

set +e
