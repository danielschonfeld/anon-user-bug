
package diagnostics

import com.granicus.grails.plugins.cookiesession.SessionPersistenceListener;
import com.granicus.grails.plugins.cookiesession.SerializableSession;
import groovy.util.logging.Log4j
import org.springframework.security.core.context.SecurityContextImpl

@Log4j
public class DumpSession implements SessionPersistenceListener{

    public void afterSessionRestored( SerializableSession session ){
      if( session == null )
        return
      log.info "*********************************"
      log.info "Session after restore:"
      for( String key : session.getValueNames() ){
        log.info "${key} : ${session.getAttribute(key)}"
      }
      log.info "*********************************"
    }

    public void beforeSessionSaved( SerializableSession session ){
      if( session == null )
        return
      log.info "*********************************"
      log.info "Session before save:"
      for( String key : session.getValueNames() ){
        if (key == "SPRING_SECURITY_CONTEXT" && ((SecurityContextImpl)session.getAttribute(key)).authentication == null) {
                log.error("IM HERE!")
              session.removeAttribute('SPRING_SECURITY_CONTEXT')
          }
        log.info "${key} : ${session.getAttribute(key)}"
      }
      log.info "*********************************"
    }
}
