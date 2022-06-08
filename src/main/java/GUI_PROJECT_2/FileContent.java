package GUI_PROJECT_2;

import java.io.File;

public class FileContent {
    private File selectedFile;
    private String filename;
    private String extension;
    private String content;

    private FileStatus fileStatus;

    /**
     * Default constructor
     */
    public FileContent() {
        extension = ".txt";
        filename = "default" + extension;
        content = "";
        fileStatus = FileStatus.NEW;
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
        this.content += content;
    }
}
