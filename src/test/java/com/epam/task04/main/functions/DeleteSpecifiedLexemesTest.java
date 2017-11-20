package com.epam.task04.main.functions;

import com.epam.task04.entity.Component;
import com.epam.task04.service.textParser.HandlerManager;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class DeleteSpecifiedLexemesTest {
    private String fullText = "It has survived - not only (five) centuries, but also the leap into 13+i-- electronic typesetting, remaining 3+5 essentially 6+9*(3-4) unchanged. It was popularised in the 5*(1*2*(3*(4*(5---j+4)-3)-2)-1) with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.\n" +
            "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using (71-(2*i--*(3*(2-1/2*2)-2)-10/2))*++i Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using (Content here), content here, making it look like readable English.\n" +
            "It is a (-5+1/2*(3+5*2---j))*1200 established fact that a reader will be of a page when looking at its layout.\n" +
            "Bye."
            ;
    int valueForI = 33;
    int valueForJ = 50;

    Component component = HandlerManager.getInstance().buildComponent(fullText, valueForI, valueForJ);
    DeleteSpecifiedLexemes deleteLexemes = new DeleteSpecifiedLexemes();

    @Test
    public void shouldReturnNotnullComponentAndDeleteTwoLexemesWhenInputIsEightAndS(){
        int lexemeLength = 8;
        String lexemeFirstLetter = "s";
        Component changedComponent = deleteLexemes.removeSpecifiedLexemes(component, lexemeLength, lexemeFirstLetter);
        Assert.assertNotNull(changedComponent);
    }

}