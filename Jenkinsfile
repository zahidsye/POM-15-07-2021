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
		
		post
	{
		failure 
		{
            		echo 'This Job is Failed - Notifications have been sent to Slack and Gmail..!!'
			
			slackSend channel: 'test-automation',
			color: 'good',
			message: "*${currentBuild.currentResult}:* Job Name: ${env.JOB_NAME} || Build Number: ${env.BUILD_NUMBER}\n More information at: ${env.BUILD_URL}"
        		
			emailext body: "*${currentBuild.currentResult}:* Job Name: ${env.JOB_NAME} || Build Number: ${env.BUILD_NUMBER}\n More information at: ${env.BUILD_URL}",
			subject: 'Test Automation Pipeline Build Status',
			to: 'zahidsye@gmail.com'
		}
        	
	}
}
