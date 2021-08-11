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
				stage('Firefox')
				{
					steps
					{
						echo "Smoke Test Execution is Started in Firefox"
						
						echo "Smoke Test Execution is Successful in Firefox"
					}
				}
			}
		}
	
	
	
	
	
	
	publishHTML (target: [
      allowMissing: false,
      alwaysLinkToLastBuild: false,
      keepAll: true,
      reportDir: 'coverage',
      reportFiles: 'index.html',
      reportName: "RCov Report"
    ])
	
	
	
	
		
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
			to: 'Pavankrishnan1993@gmail.com'
		}
        	unstable 
		{
           		echo 'This Job is Unstable - Notifications have been sent to Slack and Gmail..!!'
			
			slackSend channel: 'test-automation',
			color: 'good',
			message: "*${currentBuild.currentResult}:* Job Name: ${env.JOB_NAME} || Build Number: ${env.BUILD_NUMBER}\n More information at: ${env.BUILD_URL}"
        		
			emailext body: "*${currentBuild.currentResult}:* Job Name: ${env.JOB_NAME} || Build Number: ${env.BUILD_NUMBER}\n More information at: ${env.BUILD_URL}",
			subject: 'Test Automation Pipeline Build Status',
			to: 'Pavankrishnan1993@gmail.com'
		}
	}
}
