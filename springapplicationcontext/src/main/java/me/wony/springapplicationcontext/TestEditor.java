package me.wony.springapplicationcontext;

import java.beans.PropertyEditorSupport;

public class TestEditor extends PropertyEditorSupport {

    @Override
    public String getAsText() {
        Test value = (Test)getValue();
        return value.getId().toString();
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        setValue(new Test(Integer.parseInt(text)));
    }
}
