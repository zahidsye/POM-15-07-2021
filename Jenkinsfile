pipeline
{
	agent any
	stages
	{
		stage('Build')
		{
			steps
			{
				echo "Build is Started"
				bat "mvn clean package -DskipTests=true"
				echo "Build is Successful"
			}
		}
		
		stage('Smoke TestSuite')
		{
			parallel
			{
				stage('Chrome')
				{
					steps
					{
						echo "Smoke Test Execution is Started in Chrome"
						bat "mvn test"
						echo "Smoke Test Execution is Successful in Chrome"
					}
				}
				
			}
		}
		
		stage('Publish Reports')
		{
			parallel
			{
				stage('Extent Report')
				{
					steps
					{
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
				stage('Allure Report')
				{
					steps
					{
						echo "Allure Report is yet to be implemented"
					}
				}
			}
		}
		stage('Notifications')
		{
		
				
				stage('Gmail')
				{
					steps
					{
						emailext body: "*${currentBuild.currentResult}:* Job Name: ${env.JOB_NAME} || Build Number: ${env.BUILD_NUMBER}\n More information at: ${env.BUILD_URL}",
						subject: 'Test Automation Pipeline Build Status',
						to: 'zahidsye@gmail.com@gmail.com'
					}
				}
			
		}
	}
	post
	{
		failure 
		
		{
           		echo 'This Job is Unstable - Notifications have been sent to Slack and Gmail..!!'
			
			slackSend channel: 'test-automation',
			color: 'good',
			message: "*${currentBuild.currentResult}:* Job Name: ${env.JOB_NAME} || Build Number: ${env.BUILD_NUMBER}\n More information at: ${env.BUILD_URL}"
        		
			emailext body: "*${currentBuild.currentResult}:* Job Name: ${env.JOB_NAME} || Build Number: ${env.BUILD_NUMBER}\n More information at: ${env.BUILD_URL}",
			subject: 'Test Automation Pipeline Build Status',
			to: 'zahidsye@gmail.com'
		}
	}
}
