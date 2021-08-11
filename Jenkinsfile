pipeline {
  agent any
  triggers  {
  cron('0 4 * * *')
  }
  stages {
    stage('Test Execution') {
      steps {
        echo 'Execute Tests'
        maven(command: "clean test -Dmaven.test.skip=true"   
      }
    } 
  }
}
