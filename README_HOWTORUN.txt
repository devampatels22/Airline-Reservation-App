From: Jordon Dao
Download HSQLDB into "C:" directory (https://sourceforge.net/projects/hsqldb/files/)
Go into the "HSQLDBAsset" folder in the repository 
Move the "flights" folder into "C:\hsqldb-2.6.1\hsqldb\data"
Run db in commandline:
cd C:\hsqldb-2.6.1\hsqldb\data
then:
java -cp ../lib/hsqldb.jar org.hsqldb.server.Server --database.0 file:flights/flights --dbname.0 flights

