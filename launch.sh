find . -name "*.java" > sources.txt
javac -sourcepath . @sources.txt
java za.wethinkcode.avaj.Simulate za.wethinkcode.avaj/scenario.txt