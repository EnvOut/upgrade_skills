package com.tow.spring;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineFactory;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class ListScriptEngines {
    public static void main(String[] args) {
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine jsEngine = mgr.getEngineByName("js");
        try {
            jsEngine.eval("print('hello javascript in java')");
        } catch (ScriptException e) {
            e.printStackTrace();
        }
    }
}
