find . -name "*.java" > sources.txt
javac @sources.txt
java avaj.Simulator scenario.txt