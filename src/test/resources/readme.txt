src/test/resources should occur in the classpath before src/main/resources.  
The is the case in Maven, but not necessarily in Eclipse where you may have 
to edit the classpath order to ensure the test configuration takes precedence.