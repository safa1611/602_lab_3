node('linux') {

        stage('Create Test Stack') {
          
             git credentialsId: 'e3a0fce8-9c1b-42f8-b04a-ad6407782a23', url: 'https://github.com/safa1611/602_lab_3.git'
             withCredentials([[$class: 'AmazonWebServicesCredentialsBinding', accessKeyVariable: 'AWS_ACCESS_KEY_ID', credentialsId: '0776525b-8d0c-4b04-9237-4625bfc903d3', secretKeyVariable: 'AWS_SECRET_ACCESS_KEY']]) {
    
                   sh 'aws cloudformation create-stack --stack-name test2 --region us-east-1 --template-url https://s3.amazonaws.com/safa1611-assignment-4/docker-single-server.json --parameters ParameterKey=KeyName,ParameterValue=SEIS665-03-SpringSem2019-VA ParameterKey=YourIp,ParameterValue=$(curl ifconfig.me)/32'
                   sh 'aws cloudformation wait stack-create-complete --stack-name test2 --region us-east-1' 
                   sh 'aws cloudformation describe-stacks --stack-name test2 --region us-east-1'
                   env.docker1IP = sh returnStdout: true, script: 'aws cloudformation describe-stacks --stack-name test2 --region us-east-1 --query Stacks[].Outputs[].[OutputValue] --output text'
                     sshagent(['0d06c97d-4ce8-40b2-a52c-7cb3dea6a31b']) {
                             sh 'ssh -o StrictHostKeyChecking=no ec2-user@10.0.0.69 ${docker1IP}'
             }
        }
}
