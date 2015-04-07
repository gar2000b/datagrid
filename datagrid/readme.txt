Instructions
------------

Following the instructions from:
https://access.redhat.com/documentation/en-US/Red_Hat_JBoss_Data_Grid/6.4/html/Getting_Started_Guide/part-Introducing_Red_Hat_JBoss_Data_Grid.html

So you'll have to download things like the datagrid, quickstarts & maven repos etc...

This project demonstrates the execution of data grid in Library Mode (single mode setup).

Open cmd prompt and navigate to this project, e.g: C:\work\datagrid\datagrid
C:\work\datagrid\datagrid>

Then compile with:
C:\work\datagrid\datagrid>mvn clean compile dependency:copy-dependencies -DstripVersion

Then run with:
java -cp target/classes/;target/dependency/* com.onlineinteract.app.Quickstart