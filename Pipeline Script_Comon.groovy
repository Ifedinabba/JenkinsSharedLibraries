@Library('Sizamtek_Sharedlibs') _
pipeline{
 agent {
       label 'master' 
       }
       tools {
        maven "maven_3.9.1"
         }
         stages{
          stage('gitpull'){
            steps {
              sh "echo 'initiating git pull'"
              git 'https://github.com/Ifedinabba/fifth-demo-project.git'
             }
            }
             stage('Test+Build'){
              steps {
                common('Build')
              }
           }
           stage('Code Quality Analysis'){
                  steps {
                    common('SonarQube Report')
         }
        }
        stage('Upload Artifact'){
                  steps {
                    common('Upload into Nexus')
        }
        }
        //================================
        }// Stages Close
        }// Pipeline Close
