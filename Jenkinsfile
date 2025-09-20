pipeline {
    agent any  // Exécute sur n'importe quel agent Jenkins

    environment {
        DOCKER_HUB_REPO = 'bbabadara/etudiant-app'  // Remplacez par votre repo Docker Hub 
        IMAGE_TAG = "latest"  // Tag avec le numéro de build Jenkins
        RENDER_SERVICE_ID = 'srv-d36vii8gjchc73br64p0'  // ID de votre service Render (trouvez-le dans l'URL du service sur Render)
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm 
            }
        }

        // stage('Build Maven et Test') {
        //     steps {
        //         script {
        //             // Build Maven (comme dans votre Dockerfile, mais exécuté ici pour tests)
        //             sh 'mvn clean package -DskipTests'  // Ou sans skip si vous voulez tester
        //         }
        //     }
        // }

        stage('Build Docker Image') {
            steps {
                script {
                    // Construit l'image avec le tag
                    def customImage = docker.build("${env.DOCKER_HUB_REPO}:${env.IMAGE_TAG}")
                }
            }
        }

        stage('Push to Docker Hub') {
            steps {
                script {
                    // Login et push avec credentials
                    docker.withRegistry('https://index.docker.io/v1/', 'dockerhub_credential') {
                        def image = docker.image("${env.DOCKER_HUB_REPO}:${env.IMAGE_TAG}")
                        image.push()
                        image.push('latest')  // Optionnel : tag 'latest'
                    }
                }
            }
        }

        stage('Deploy to Render') {
            steps {
                script {
                    // Déclenche un redéploiement sur Render via API
                    sh """
                        curl -X POST \
                            -H "Authorization: Bearer \${render_api}" \
                            -H "Content-Type: application/json" \
                            https://api.render.com/v1/services/\${RENDER_SERVICE_ID}/deploys
                    """
                }
            }
        }
    }

    post {
        always {
            // Nettoyage : supprime les images locales pour économiser de l'espace
            sh script: 'docker rmi ${DOCKER_HUB_REPO}:${IMAGE_TAG} || true'
        }
        success {
            echo 'Pipeline réussi ! Image pushée et déployée sur Render.'
        }
        failure {
            echo 'Pipeline échoué. Vérifiez les logs.'
        }
    }
}