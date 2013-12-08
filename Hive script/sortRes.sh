#!/bin/bash
#script to count the total numbers of resteraunt for specific type
hadoop fs -rm /user/idcuser/hive-input1/*.*
hadoop fs -put /home/idcuser/HadoopOutput/rsinput.txt /user/idcuser/hive-input1
hive -f /home/idcuser/creatTable.sql
hive -f /home/idcuser/sortRes.sql
hadoop fs -cat /user/idcuser/hive-input1/0*
