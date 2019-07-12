package ru.sportexpress.menuApp.exceptions;

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus
import jdk.tools.jlink.internal.ImageFileCreator.resourceName


@ResponseStatus(value = HttpStatus.NOT_FOUND)
class ResourceNotFoundException(val resourceName: String, val fieldName: String, val fieldValue: Any) : RuntimeException(String.format("%s not found with %s : '%s'", resourceName, fieldName, fieldValue))