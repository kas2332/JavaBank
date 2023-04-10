import javax.swing.*;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import javax.swing.plaf.basic.BasicComboPopup;
import java.awt.*;

/**
 * This class will change the bounds of the JComboBox popup menu to support
 * different functionality. It will support the following features:
 * -  a horizontal scrollbar can be displayed when necessary
 * -  the popup can be wider than the combo box
 * -  the popup can be displayed above the combo box
 * <p>
 * Class will only work for a JComboBox that uses a BasicComboPop.
 */
public class BoundsPopupMenuListener implements PopupMenuListener {
    private boolean scrollBarRequired = true;
    private boolean popupWider = true;
    private int maximumWidth = -1;
    private boolean popupAbove = true;
    private JScrollPane scrollPane;

    /**
     * Convenience constructor to allow the display of a horizontal scrollbar
     * when required.
     */
    public BoundsPopupMenuListener() {
        this(true, true, -1, true);
    }

    /**
     * General purpose constructor to set all popup properties at once.
     *
     * @param scrollBarRequired display a horizontal scrollbar when the
     *                          preferred width of popup is greater than width of scrollPane.
     * @param popupWider        display the popup at its preferred with
     * @param maximumWidth      limit the popup width to the value specified
     *                          (minimum size will be the width of the combo box)
     * @param popupAbove        display the popup above the combo box
     */
    public BoundsPopupMenuListener(
            boolean scrollBarRequired, boolean popupWider, int maximumWidth, boolean popupAbove) {
        setScrollBarRequired(scrollBarRequired);
        setPopupWider(popupWider);
        setMaximumWidth(maximumWidth);
        setPopupAbove(popupAbove);
    }

    /**
     * Set the maximum width for the popup. This value is only used when
     * setPopupWider( true ) has been specified. A value of -1 indicates
     * that there is no maximum.
     *
     * @param maximumWidth the maximum width of the popup
     */
    public void setMaximumWidth(int maximumWidth) {
        this.maximumWidth = maximumWidth;
    }

    /**
     * Change the location of the popup relative to the combo box.
     *
     * @param popupAbove true display popup above the combo box,
     *                   false display popup below the combo box.
     */
    public void setPopupAbove(boolean popupAbove) {
        this.popupAbove = popupAbove;
    }

    /**
     * Change the width of the popup to be the greatest of the width of the
     * combo box or the preferred width of the popup. Normally the popup width
     * is always the same size as the combo box width.
     *
     * @param popupWider true adjust the width as required.
     */
    public void setPopupWider(boolean popupWider) {
        this.popupWider = popupWider;
    }

    /**
     * For some reason the default implementation of the popup removes the
     * horizontal scrollBar from the popup scroll pane which can result in
     * the truncation of the rendered items in the popup. Adding a scrollBar
     * back to the scrollPane will allow horizontal scrolling if necessary.
     *
     * @param scrollBarRequired true add horizontal scrollBar to scrollPane
     *                          false remove the horizontal scrollBar
     */
    public void setScrollBarRequired(boolean scrollBarRequired) {
        this.scrollBarRequired = scrollBarRequired;
    }

    /**
     * Alter the bounds of the popup just before it is made visible.
     */
    @Override
    public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
        JComboBox comboBox = (JComboBox) e.getSource();

        if (comboBox.getItemCount() == 0) return;

        final Object child = comboBox.getAccessibleContext().getAccessibleChild(0);

        if (child instanceof BasicComboPopup) {
            SwingUtilities.invokeLater(() -> customizePopup((BasicComboPopup) child));
        }
    }

    protected void customizePopup(BasicComboPopup popup) {
        scrollPane = getScrollPane(popup);

        if (popupWider)
            popupWider(popup);

        checkHorizontalScrollBar(popup);

        //  For some reason in JDK7 the popup will not display at its preferred
        //  width unless its location has been changed from its default
        //  (i.e. for normal "pop down" shift the popup and reset)

        Component comboBox = popup.getInvoker();
        Point location = comboBox.getLocationOnScreen();

        if (popupAbove) {
            int height = popup.getPreferredSize().height;
            popup.setLocation(location.x, location.y - height);
        } else {
            int height = comboBox.getPreferredSize().height;
            popup.setLocation(location.x, location.y + height - 1);
            popup.setLocation(location.x, location.y + height);
        }
    }

    /*
     *  Adjust the width of the scroll-pane used by the popup
     */
    protected void popupWider(BasicComboPopup popup) {
        JList<Object> list = popup.getList();

        //  Determine the maximum width to use:
        //  a) determine the popup preferred width
        //  b) limit width to the maximum if specified
        //  c) ensure width is not less than the scroll pane width

        int popupWidth = list.getPreferredSize().width
                + 5  // make sure horizontal scrollbar doesn't appear
                + getScrollBarWidth(popup, scrollPane);

        if (maximumWidth != -1) {
            popupWidth = Math.min(popupWidth, maximumWidth);
        }

        Dimension scrollPaneSize = scrollPane.getPreferredSize();
        popupWidth = Math.max(popupWidth, scrollPaneSize.width);

        //  Adjust the width

        scrollPaneSize.width = popupWidth;
        scrollPane.setPreferredSize(scrollPaneSize);
        scrollPane.setMaximumSize(scrollPaneSize);
    }

    /*
     *  This method is called every time:
     *  - to make sure the viewport is returned to its default position
     *  - to remove the horizontal scrollbar when it is not wanted
     */
    private void checkHorizontalScrollBar(BasicComboPopup popup) {
        //  Reset the viewport to the left

        JViewport viewport = scrollPane.getViewport();
        Point p = viewport.getViewPosition();
        p.x = 0;
        viewport.setViewPosition(p);

        //  Remove the scrollbar so it is never painted

        if (!scrollBarRequired) {
            scrollPane.setHorizontalScrollBar(null);
            return;
        }

        //	Make sure a horizontal scrollbar exists in the scroll-pane

        JScrollBar horizontal = scrollPane.getHorizontalScrollBar();

        if (horizontal == null) {
            horizontal = new JScrollBar(JScrollBar.HORIZONTAL);
            scrollPane.setHorizontalScrollBar(horizontal);
            scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        }

        //	Potentially increase height of scroll pane to display the scrollbar

        if (horizontalScrollBarWillBeVisible(popup, scrollPane)) {
            Dimension scrollPaneSize = scrollPane.getPreferredSize();
            scrollPaneSize.height += horizontal.getPreferredSize().height;
            scrollPane.setPreferredSize(scrollPaneSize);
            scrollPane.setMaximumSize(scrollPaneSize);
            scrollPane.revalidate();
        }
    }

    /*
     *  Get the scroll pane used by the popup so its bounds can be adjusted
     */
    protected JScrollPane getScrollPane(BasicComboPopup popup) {
        JList<Object> list = popup.getList();
        Container c = SwingUtilities.getAncestorOfClass(JScrollPane.class, list);

        return (JScrollPane) c;
    }

    /*
     *  I can't find any property on the scrollBar to determine if it will be
     *  displayed or not so use brute force to determine this.
     */
    protected int getScrollBarWidth(BasicComboPopup popup, JScrollPane scrollPane) {
        int scrollBarWidth = 0;
        JComboBox comboBox = (JComboBox) popup.getInvoker();

        if (comboBox.getItemCount() > comboBox.getMaximumRowCount()) {
            JScrollBar vertical = scrollPane.getVerticalScrollBar();
            scrollBarWidth = vertical.getPreferredSize().width;
        }

        return scrollBarWidth;
    }

    /*
     *  I can't find any property on the scrollBar to determine if it will be
     *  displayed or not so use brute force to determine this.
     */
    protected boolean horizontalScrollBarWillBeVisible(BasicComboPopup popup, JScrollPane scrollPane) {
        JList<Object> list = popup.getList();
        int scrollBarWidth = getScrollBarWidth(popup, scrollPane);
        int popupWidth = list.getPreferredSize().width + scrollBarWidth;

        return popupWidth > scrollPane.getPreferredSize().width;
    }

    @Override
    public void popupMenuCanceled(PopupMenuEvent e) {
    }

    @Override
    public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
        //  In its normal state the scroll-pane does not have a scrollbar

        if (scrollPane != null) {
            scrollPane.setHorizontalScrollBar(null);
        }
    }
}
