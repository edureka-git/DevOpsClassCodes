
pipeline{
    tools{
        jdk 'myjava'
        maven 'mymaven'
    }
    agent none
      stages{
           stage('Checkout'){
               agent any
              steps{
                 git 'https://github.com/Sonal0409/DevOpsClassCodes.git'
              }
          }
          stage('Compile'){
              agent any
              steps{
                  sh 'mvn compile'
              }
          }
          stage('CodeReview'){
              agent any
              steps{
                  sh 'mvn pmd:pmd'
              }
          }
           stage('UnitTest'){
               agent any
              steps{
                  sh 'mvn test'
              }
          }
           stage('MetricCheck'){
               agent any
              steps{
                  sh 'mvn cobertura:cobertura -Dcobertura.report.format=xml'
              }
          }
          stage('Package'){
              agent any
              steps{
                  sh 'mvn package'
              }
          }
          stage('Deploy'){
      agent any
      steps{
        sh label: '', script: '''rm -rf mydockerfile
mkdir mydockerfile
cd mydockerfile
cp /var/lib/jenkins/workspace/Package/target/addressbook.war .
touch dockerfile
cat <<EOT>> dockerfile
From tomcat
ADD addressbook.war /usr/local/tomcat/webapps
EXPOSE 8080
CMD ["catalina.sh", "run"]
EOT
sudo docker build -t myimage:$BUILD_NUMBER .
sudo docker run -itd -P myimage:$BUILD_NUMBER'''
      }
    }
          
      }
}
