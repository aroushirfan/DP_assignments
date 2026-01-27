package abstract_factory;

public class FactoryA extends UIFactory {
    @Override
    public Button createButton(String text) {
        return new ButtonA(text);
    }
    @Override
    public Checkbox createCheckbox(String text) {
        return new CheckboxA(text);
    }
    public TextField createTextField(String text) {
        return new TextFieldA(text);
    }
}
