pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "mymaven"
        jdk "myjava"
    }

    stages {
			stage('Compile') {
				steps {
					// Get some code from a GitHub repository
					git 'https://github.com/edureka-git/DevOpsClassCodes.git'

					// Run Maven on a Unix agent.
					sh "mvn compile"

					// To run Maven on a Windows agent, use
					// bat "mvn complie"
				}
			}
        stage('CodeReview') {
            steps {
                // Get some code from a GitHub repository
                //git 'https://github.com/edureka-git/DevOpsClassCodes.git'

                // Run Maven on a Unix agent.
                sh "mvn pmd:pmd"

                // To run Maven on a Windows agent, use
                // bat "mvn complie"
            }
        }
    }
}
