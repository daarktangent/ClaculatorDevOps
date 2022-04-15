pipeline {
    /* The environment specifies the credentials required to push my image to dockerhub */
    environment {
        registry = "daarktangent/calculatorusingdevops"
        registryCredential = 'docker'
        dockerImage = ''
    }

    agent any

    stages {
        stage('step 1 Git') {
            steps {
                // Get some code from a GitHub repository
                			git url: 'https://github.com/daarktangent/ClaculatorDevOps.git', branch: 'master',
                 credentialsId: 'git_cred'
            }
        }

        stage('step 2 Build maven') {
            steps {
                // Compile and package code without unit testing.
                sh "mvn -B -DskipTests clean package"
            }
        }

        stage('step 3 Test') {
            steps {
                // Unit testing on compiled source code.
                sh "mvn test"
            }
        }

        stage('step 4 Building docker image') {
            steps{
                script {
                    dockerImage = docker.build registry + ":latest"
                }
            }
        }

        stage('step 5 Push docker image to dockerhub') {
            steps{
                script {
                    docker.withRegistry( '', registryCredential ) {
                    dockerImage.push()
                    }
                }
            }
        }

        stage('Step 6 Ansible image deploy'){
            steps{
                ansiblePlaybook becomeUser: null, colorized: true, disableHostKeyChecking: true, installation: 'Ansible', inventory: 'inventory', playbook: 'playbook.yml', sudoUser: null
                }

        }
//         stage('Step 7 Ansible container creation'){
//             steps{
//                 ansiblePlaybook becomeUser: null, colorized: true, disableHostKeyChecking: true, installation: 'Ansible', inventory: 'ansible-docker-deploy/inventory', playbook: 'ansible-docker-deploy/create-container.yml', sudoUser: null
//                 }
//
//         }
    }
}