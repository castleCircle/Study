package me.wony.springapplicationcontext;


import java.beans.PropertyEditorSupport;

public class EventEditor extends PropertyEditorSupport {

    @Override
    public String getAsText() {
//        Event event = (Event)getValue();
//        return event.getId().toString();
        return null;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        setValue(new Event(Integer.parseInt(text)));
    }
}
