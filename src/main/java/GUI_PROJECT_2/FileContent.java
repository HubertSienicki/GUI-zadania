package GUI_PROJECT_2;

import java.io.File;

public class FileContent {
    private File selectedFile;
    private String filename;
    private String extension;
    private String content;
    private String modifiedContent;
    private UsedFontSize currentFontSize;
    private UsedFontSize previousFontSize;
    private FileStatus fileStatus;

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
        fileStatus = FileStatus.NEW;
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

    //Getters and setters
    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getExtension() {
        return extension;
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
}
