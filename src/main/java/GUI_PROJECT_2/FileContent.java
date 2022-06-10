package GUI_PROJECT_2;

import java.io.File;

/**
 * Controls content of an opened file and variables related
 * to the jTextArea inside of View class
 */
public class FileContent {


    /**
     * Default constructor
     */
    public FileContent() {
        extension = ".txt";
        filename = "default" + extension;
        content = "";
        modifiedContent = "";
        currentFontSize = UsedFontSize.SIZE_8PT;
        previousFontSize = UsedFontSize.SIZE_8PT;
        currentBackground = Colors.WHITE;
        currentForeground = Colors.BLACK;
        previousBackground = currentBackground;
        previousForeground = currentForeground;
        fileStatus = FileStatus.NEW;
    }
    public Colors getCurrentBackground() {
        return currentBackground;
    }

    public void setCurrentBackground(Colors currentBackground) {
        this.currentBackground = currentBackground;
    }

    public Colors getCurrentForeground() {
        return currentForeground;
    }

    public void setCurrentForeground(Colors currentForeground) {
        this.currentForeground = currentForeground;
    }

    public Colors getPreviousBackground() {
        return previousBackground;
    }

    public void setPreviousBackground(Colors previousBackground) {
        this.previousBackground = previousBackground;
    }

    public Colors getPreviousForeground() {
        return previousForeground;
    }

    public void setPreviousForeground(Colors previousForeground) {
        this.previousForeground = previousForeground;
    }

    public String getModifiedContent() {
        return modifiedContent;
    }

    public void setModifiedContent(String modifiedContent) {
        this.modifiedContent = modifiedContent;
    }

    public UsedFontSize getPreviousFontSize() {
        return previousFontSize;
    }

    public void setPreviousFontSize(UsedFontSize previousFontSize) {
        this.previousFontSize = previousFontSize;
    }

    public UsedFontSize getCurrentFontSize() {
        return currentFontSize;
    }

    public void setFontSize(UsedFontSize fontSize) {
        this.currentFontSize = fontSize;
    }

    public FileStatus getFileStatus() {
        return fileStatus;
    }

    public void setFileStatus(FileStatus fileStatus) {
        this.fileStatus = fileStatus;
    }

    public File getSelectedFile() {
        return selectedFile;
    }

    public void setSelectedFile(File selectedFile) {
        this.selectedFile = selectedFile;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    //VARIABLES -> DO NOT EDIT
    private File selectedFile;
    private String filename;
    private String extension;
    private String content;
    private String modifiedContent;
    private UsedFontSize currentFontSize;
    private UsedFontSize previousFontSize;
    private FileStatus fileStatus;
    private Colors currentBackground;
    private Colors currentForeground;
    private Colors previousBackground;
    private Colors previousForeground;
}
