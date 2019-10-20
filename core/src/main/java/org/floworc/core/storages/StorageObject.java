package org.floworc.core.storages;

import com.google.common.io.CharStreams;
import lombok.AllArgsConstructor;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;

@AllArgsConstructor
public class StorageObject {
    private StorageInterface storageInterface;
    private URI uri;

    public URI getUri() {
        return uri;
    }

    public String getContent() throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(storageInterface.get(this.uri));
        String content = CharStreams.toString(inputStreamReader);
        inputStreamReader.close();;

        return content;
    }

    public InputStream getInputStream() throws FileNotFoundException {
        return storageInterface.get(this.uri);
    }

    @Override
    public String toString() {
        return this.uri.toString();
    }
}