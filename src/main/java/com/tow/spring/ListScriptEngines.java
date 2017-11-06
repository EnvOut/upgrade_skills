package com.tow.spring;

import javax.script.ScriptEngineFactory;
import javax.script.ScriptEngineManager;

public class ListScriptEngines {
    public static void main(String[] args) {
        ScriptEngineManager mgr = new ScriptEngineManager();
        for (ScriptEngineFactory factory : mgr.getEngineFactories()) {
            String engineName = factory.getEngineName();
            String languageName = factory.getLanguageName();
            String version = factory.getLanguageVersion();

            System.out.println(new StringBuffer()
                    .append("engineName: ").append(engineName)
                    .append("languageName: ").append(languageName)
                    .append("version: ").append(version));
        }
    }
}
