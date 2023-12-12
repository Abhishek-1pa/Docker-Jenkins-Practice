// node{
//     stage('Build'){
//         echo "Build"
//     }
//     stage('Unit Test'){
//         echo "Unit Test"
//     }
//     stage('Integration Test'){
//         echo "Integration Test"
//     }

// }
pipeline{
    agent any
    environment{
        dockerHome=tool 'myDocker'
        mavenHome=tool 'myMaven'
        PATH = "$dockerHome/bin:$mavenHome/bin:$PATH"
    }
    stages{
        stage('Build'){
            steps{
                sh 'mvn --version'
                sh 'docker version'
                echo "Build"
                echo "PATH - $PATH"
                echo "BUILD_NUMBER - $env.BUILD_NUMBER"
                echo "BUILD_ID - $env.BUILD_ID"
                echo "JOB_NAME - $env.JOB_NAME"
                echo "BUILD_TAG - $env.BUILD_TAG"
                echo "BUILD_URL - $env.BUILD_URL"

            }
        }

        stage('Comiple'){
            steps{
                sh "mvn clean compile"
            }
        }

        stage('Test'){
            steps{
                sh "mvn test"
            }
        }

        stage('Package'){
            steps{
                sh "mvn clean package"
            }
        }

        stage('Build Docker Image'){
            steps{
                //docker build -t demo:$env.BUILD_TAG
                script{
                    dockerImage = docker.build("demo:${$env.BUILD_TAG}")
                }
                
            }
        }

        stage('Push Docker Image'){
            steps{
                script{
                    docker.withRegistry('','dockerhub'){
                        dockerImage.push();
                        dockerImage.push('latest');
                    }
                }
            }
        }
    }
    post{
        always{
            echo 'Always run'
        }
        success{
            echo 'SUCCESS'
        }
        failure{
            echo 'FAILURE'
        }
    }
}