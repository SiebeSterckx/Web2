# To start project in IntelliJ:

Under 'File'<'Project Structure...':
1. Make module
2. Make artifact: 'Web Application: Exploded' + select the module
---
3. Build the artifact
---
4. Setup Tomcat Server Local:

   Under 'Server' tab:
   - Application server: choose file location of the Tomcat server 
   - URL: 'http://localhost:8080/ARTIFACT_NAME/'
     ARTIFACT_NAME example: my artifact has 'Sterckx-Siebe:war exploded' as name, so the ARTIFACT_NAME should be 'Sterckx_Siebe_war_exploded'
   - On 'Update' action: Restart server
   - HTTP port: 8080
   - JMX port: 1099
   - Before launch: Build + Build artifact
   - Click 'Apply' & 'OK'
   
   Under 'Deployment' tab:
   - Add the artifact
---
5. Run the project/Tomcat server

