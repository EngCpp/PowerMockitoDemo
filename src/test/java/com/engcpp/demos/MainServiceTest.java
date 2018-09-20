package com.engcpp.demos;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.Matchers.anyString;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import static org.powermock.api.mockito.PowerMockito.doReturn;
import static org.powermock.api.mockito.PowerMockito.when;
import static org.powermock.api.support.membermodification.MemberMatcher.method;
import org.powermock.core.classloader.annotations.PrepareForTest;

import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;
import static org.powermock.reflect.Whitebox.setInternalState;

/**
 *
 * @author engcpp
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(value = {MainService.class})
public class MainServiceTest {
    
    private MainService mainService;    
    private CacheHolder cacheHolder;
    
   @Before
   public void setUp(){
        mainService = PowerMockito.spy(new MainService());
        cacheHolder = PowerMockito.mock(CacheHolder.class);
        setInternalState(mainService, CacheHolder.class, cacheHolder);        
   }
    
    @Test
   public void testDataMock() throws Exception {
        doReturn("XYZW").when(cacheHolder).getCache();
        final String data = mainService.getData();
        assertEquals(data, "ABCD");
   }
    
   @Test
   public void testPrivateMock() throws Exception {  
        doReturn("XYZW").when(cacheHolder).getCache();       
        when(mainService, method(MainService.class, "isValid", String.class))
                .withArguments(anyString())
                .thenReturn(true);

       final String data = mainService.getData();
       assertEquals(data, "XYZW");       
   }

}
