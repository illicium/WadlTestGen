package com.pomortsev.wadltestgen.util;

import java.io.File;
import java.io.FileFilter;

/**
 * A FileFilter that filters all files that aren't templates so they can be copied
 * from the template directory to the output directory
 */
public class StaticFileFilter implements FileFilter {
    TemplateFileFilter templateFileFilter = new TemplateFileFilter();

    public boolean accept(File file) {
        // we can't just invert the TemplateFileFilter because then we'd copy
        // underscore-prefixed templates
        return !file.getName().endsWith("ftl") &&
               !file.isHidden();
    }
}
