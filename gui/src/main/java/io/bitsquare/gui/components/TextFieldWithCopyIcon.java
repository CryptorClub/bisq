/*
 * This file is part of Bitsquare.
 *
 * Bitsquare is free software: you can redistribute it and/or modify it
 * under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or (at
 * your option) any later version.
 *
 * Bitsquare is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU Affero General Public
 * License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with Bitsquare. If not, see <http://www.gnu.org/licenses/>.
 */

package io.bitsquare.gui.components;

import de.jensd.fx.fontawesome.AwesomeDude;
import de.jensd.fx.fontawesome.AwesomeIcon;
import io.bitsquare.common.util.Utilities;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.AnchorPane;

import java.util.function.Consumer;

public class TextFieldWithCopyIcon extends AnchorPane {

    private final StringProperty text = new SimpleStringProperty();
    private final TextField textField;
    private Consumer<String> handler;


    ///////////////////////////////////////////////////////////////////////////////////////////
    // Constructor
    ///////////////////////////////////////////////////////////////////////////////////////////

    public TextFieldWithCopyIcon() {
        Label copyIcon = new Label();
        copyIcon.setLayoutY(3);
        copyIcon.getStyleClass().add("copy-icon");
        Tooltip.install(copyIcon, new Tooltip("Copy to clipboard"));
        AwesomeDude.setIcon(copyIcon, AwesomeIcon.COPY);
        AnchorPane.setRightAnchor(copyIcon, 0.0);
        copyIcon.setOnMouseClicked(e -> {
            if (getText() != null && getText().length() > 0) {
                Utilities.copyToClipboard(getText());
                if (handler != null)
                    handler.accept(getText());
            }
        });
        textField = new TextField();
        textField.setEditable(false);
        textField.textProperty().bindBidirectional(text);
        AnchorPane.setRightAnchor(textField, 30.0);
        AnchorPane.setLeftAnchor(textField, 0.0);
        textField.focusTraversableProperty().set(focusTraversableProperty().get());
        focusedProperty().addListener((ov, oldValue, newValue) -> textField.requestFocus());

        getChildren().addAll(textField, copyIcon);
    }

    public void setPromptText(String value) {
        textField.setPromptText(value);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////
    // Getter/Setter
    ///////////////////////////////////////////////////////////////////////////////////////////

    private String getText() {
        return text.get();
    }

    public StringProperty textProperty() {
        return text;
    }

    public void setText(String text) {
        this.text.set(text);
    }

    public void setHandler(Consumer<String> handler) {
        this.handler = handler;
    }
}
