pipeline {
  agent any
  triggers  {
  cron('0 4 * * *')
  }
  stages
	{
  stage('Build') {
			steps
			{
				echo "Build is Started"
				bat "mvn clean package -DskipTests=true"
				echo "Build is Successful"
			}
		}
  
    stage('Smoke Test Execution') {
      steps {
        			echo "Smoke Test Execution is Started in Chrome"
					bat "mvn test"
					echo "Smoke Test Execution is Successful"
      }
    }
  

  stage('Publish Reports'){
					steps		{
						publishHTML([
					          	allowMissing: false, 
            					alwaysLinkToLastBuild: true, 
            					keepAll: false, 
					          	reportDir: 'target', 
            					reportFiles: 'ExecutionReport*.html', 
            					reportName: 'Extent HTML Report', 
            					reportTitles: ''])
					}
				}
	}
}
