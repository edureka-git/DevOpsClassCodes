package com.edurekademo.utilities;

import java.io.IOException;

import com.edurekademo.utilities.LoggerStackTraceUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExceptionThrower {

        private static final Logger LOG=LoggerFactory.getLogger(ExceptionThrower.class);
        public void getCounter() { 
                int i = 1/0; // this will throw the error...
                LOG.info(""+i);
        }
        
        public void doNothing() throws IOException {
                throw new IOException("TESTIOEXCEPTION"); 
        }
        
        private void doXXX() { 
                try { 
                        doYYY(); 
                  String s = null; 
                  if("sss".equals(s)) { 
                          LOG.info("ssss");
                  }
                }
                catch (Exception e){ 
                        LOG.error(new LoggerStackTraceUtil().getErrorMessage(e)); 
                }
        }
        
        private void doYYY() { 
                LOG.error(new LoggerStackTraceUtil().getErrorMessage(new Exception("DEAR")));
        }
        public void doCheck() throws Exception { 
                try { 
                        doXXX(); 
                        doNothing(); 
                }
                catch (Exception e){ 
                        throw new Exception("TEST MESSAGE"); 
                }
        }
}
