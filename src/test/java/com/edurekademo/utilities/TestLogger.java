package com.edurekademo.utilities;
import com.edurekademo.utilities.LoggerStackTraceUtil;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestLogger {

        private static final Logger LOG = LoggerFactory.getLogger(TestLogger.class);
        @Test
        public void testGetErrorMessage1() {
                String s = "Not Implemented";
                try { 
                        int f = 1/0; 
                        System.out.println(f);
                }
                catch (Exception e){
                        LoggerStackTraceUtil util = new LoggerStackTraceUtil();
                        s = util.getErrorMessage(e); 
                }
                LOG.info(s);
                 assert(s.contains(System.getProperty("line.separator"))); 
        }
        @Test
        public void testGetErrorMessage2() {
                String s = "Not Implemented";
                LoggerStackTraceUtil util = new LoggerStackTraceUtil();

                try { 
                        int f = 1/0; 
                        LOG.info(""+f);
                }
                catch (Exception e){
                        s = util.getErrorMessage(e); 
                }
                LOG.info(s);
                assert(s.contains("/ by zero"));  
        }

        @Test
        public void testGetErrorMessage3() {
                String s = "Not Implemented";
                try { 
                        ExceptionThrower g = new ExceptionThrower(); 
                        g.getCounter();
                }
                catch (Exception e){
                        LoggerStackTraceUtil util = new LoggerStackTraceUtil();
                        s = util.getErrorMessage(e); 
                }
                LOG.info(s);
                assert(s.contains("/ by zero"));  
        }

        @Test
        public void testGetErrorMessage4() {
                String s = "Not Implemented";
                try { 
                        ExceptionThrower g = new ExceptionThrower(); 
                        g.doNothing();
                }
                catch (Exception e){
                        LoggerStackTraceUtil util = new LoggerStackTraceUtil();
                        s = util.getErrorMessage(e); 
                }
                LOG.info(s);
                assert(s.contains("TESTIOEXCEPTION"));  
        }
        
        @Test
        public void testGetErrorMessage5() {
                String s = "Not Implemented";
                try { 
                        ExceptionThrower g = new ExceptionThrower(); 
                        g.doCheck();

                }
                catch (Exception e){
                        LoggerStackTraceUtil util = new LoggerStackTraceUtil();
                        s = util.getErrorMessage(e); 
                }
				finally { 
						LOG.info(s);
						System.out.println("***** "+s); 
						assert(s.contains("TEST MESSAGE"));  

				}
        }

}
