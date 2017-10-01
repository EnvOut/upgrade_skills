package com.tow.spring.xml;

public class StandartLookupDemoBean implements DemoBean {
    private MyHelper myHelper;

    public MyHelper getMyHelper() {
        return myHelper;
    }

    public void setMyHelper(MyHelper myHelper) {
        this.myHelper = myHelper;
    }

    @Override
    public void someOperation() {
        myHelper.doSomethingHelpful();
    }

}
