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
	
	
	
	
		stage('Results'){
			steps
					{
	
	publishHTML (target: [
      allowMissing: false,
      alwaysLinkToLastBuild: false,
      keepAll: true,
      reportDir: 'reports/',
      reportFiles: '*.*',
      reportName: "RCov Report"
    ])
		}
		}
	
	
	
	
		
	}

}
