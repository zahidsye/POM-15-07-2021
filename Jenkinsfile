pipeline {
  agent any
  triggers  {
  cron('0 4 * * *')
  }
  stages {
    stage('Test Execution') {
      steps {
        echo 'Execute Tests'
        bat "mvn clean test -Dsuite=testng.xml" 
          
      }
    } 
  }
}
