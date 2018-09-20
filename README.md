# Web Automation
Web Automation Framework using Java, TestNG, Selenium Webdriver

*Note: Tested only on Mac Device*

*Path to test: src/test/java/smokeTests/CoveragePageTest*

#### Steps to run the tests
   
   1. Install git [Tutorial on Installation](https://gist.github.com/derhuerst/1b15ff4652a867391f03)
           - Enter following command on your terminal
            
                  $ git --version
                   
       - If installed successful you should see something like this on your terminal
              
              git version 2.15.1 (Apple Git-101)
   
  
   2. Install Chrome browser yon your machine [download link](https://support.google.com/chrome/answer/95346?co=GENIE.Platform%3DDesktop&hl=en)
      
   
   3. Install Java 8 [Tutorial on Installation](http://www.wikihow.com/Install-the-Java-Software-Development-Kit)
     - Enter following command on your terminal
     
           $ java -version 
           
      - If installed successful you should see something like this on your terminal
           
                java version "1.8.0_121"
                
   
   4. Install latest Maven [Tutorial on Installation](http://www.baeldung.com/install-maven-on-windows-linux-mac``````)
     - Enter following command on your terminal
           
           $ mvn -version 
                 
      - If installed successful you should see something like this on your terminal
                 
                Apache Maven 3.5.0 (ff8f5e7444045639af65f6095c62210b5713f426; 2017-04-03T12:39:06-07:00)
                Maven home: /usr/local/Cellar/maven/3.5.0/libexec
                Java version: 1.8.0_121, vendor: Oracle Corporation
                Java home: /Library/Java/JavaVirtualMachines/jdk1.8.0_121.jdk/Contents/Home/jre
                Default locale: en_US, platform encoding: UTF-8
                OS name: "mac os x", version: "10.12.6", arch: "x86_64", family: "mac"
   
   4. Clone the project
        
            $ git clone https://github.com/lazymachine/Livongo.git            
   
   
   4. On your terminal, go to the project downloaded directory, then enter the following command
                  
            $ cd Livongo/
            $ mvn clean install test -DsuiteXmlFile=livongo-sample-testsuite.xml

   
   5. To see the test results:
        -  go to project folder and under it look for target folder
        -  then under target folder find surefire-reports folder
        -  right click and open emailable-reports.html

   
   6.  Screen-captured [demo video](https://youtu.be/j2-pvFAVOHE) of the project running on a Mac Device
                          
