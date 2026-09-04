package com;

import com.page.NavigationMenu;
import com.structure.Letter;
import org.testng.Assert;
import org.testng.annotations.Test;


public class SaveLetterTest extends BaseTest {

    @Test
    public void saveLetterToDraft() {
        Letter actualletter = new NavigationMenu()
                .openLetterBox()
                .fillLetter(expectedletter)
                .saveLetterBox()
                .getNavigationMenu()
                .openDraftPage()
                .openLetterInDraftPage(expectedletter).getLetter();
        Assert.assertEquals(expectedletter, actualletter);
    }

}
