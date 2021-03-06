#!./lib/runner.groovy
// Generates server-side metadata for MongoDB auto-installation
import net.sf.json.*

def json = []
def versions = new URL('http://api.sdkman.io/candidates/grails').text.split(',').reverse()
versions.each {
    json << [id:it, name:"Grails $it".toString(), url:"https://github.com/grails/grails-core/releases/download/v${it}/grails-${it}.zip".toString()]
}

lib.DataWriter.write("com.g2one.hudson.grails.GrailsInstaller",JSONObject.fromObject([list:json]));
