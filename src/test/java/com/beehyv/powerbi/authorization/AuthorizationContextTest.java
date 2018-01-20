package com.beehyv.powerbi.authorization;

import org.junit.Assert;
import org.junit.Test;

public class AuthorizationContextTest {



    @Test
    public void getFirstAccessTokenTest(){
        Assert.assertNotNull(Util.getAuthorizationContext().getAccessToken());
    }

    @Test
    public void getNewAccessTokenTest(){
        AuthorizationContext authorizationContext = Util.getAuthorizationContext();
        Assert.assertNotNull(authorizationContext.getAccessToken());
        Assert.assertNotNull(authorizationContext.getAccessToken());
    }

}
