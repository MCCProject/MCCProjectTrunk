CREATE TABLE IF NOT EXISTS  Resteraunt5(NAME STRING, RATING STRING, DISTANCE STRING, ADDRESS STRING, RTYPE STRING, PHONE STRING, URL STRING)
       COMMENT 'Resteraunt5 Table'
       ROW FORMAT DELIMITED FIELDS TERMINATED BY '\;'
       STORED AS TEXTFILE;
LOAD DATA INPATH 'hive-input1/rsinput.txt' OVERWRITE INTO TABLE Resteraunt5; 
