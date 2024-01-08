def call(credId, tomcatIp, user, warName){
  sshagent([credId]){
    sh "scp -o StrictHostKeyChecking=no target/${warName} ${user}@${tomcatIp}:/opt/tomcat9/webapps"
    sh "ssh ${user}@${tomcatIp} /opt/tomcat9/bin/shutdown.sh"
    sh "ssh ${user}@${tomcatIp} /opt/tomcat9/bin/startup.sh"
  }
}
