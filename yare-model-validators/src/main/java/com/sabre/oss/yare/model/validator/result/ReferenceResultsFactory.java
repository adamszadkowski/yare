/*
 * MIT License
 *
 * Copyright 2018 Sabre GLBL Inc.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.sabre.oss.yare.model.validator.result;

import com.sabre.oss.yare.model.validator.ValidationResult;

import java.util.Set;

public class ReferenceResultsFactory {

    public ValidationResult undefinedPredicate() {
        return ValidationResult.error(
                "rule.predicate.not-defined",
                "Predicate Error: predicate was not specified"
        );
    }

    public ValidationResult duplicatedNames(Set<String> duplicatedNames) {
        return ValidationResult.error(
                "rule.ref.duplicated-names",
                String.format("Reference Error: found name duplication -> %s", duplicatedNames)
        );
    }

    public ValidationResult reservedNames(String reservedName) {
        return ValidationResult.error(
                "rule.ref.reserved-names",
                String.format("Reference Error: reserved names are used -> [%s]", reservedName)
        );
    }

    public ValidationResult emptyReference() {
        return ValidationResult.error(
                "rule.ref.empty-reference",
                "Reference Error: empty reference used"
        );
    }

    public ValidationResult unknownReference(String referenceName) {
        return ValidationResult.error(
                "rule.ref.unknown-reference",
                String.format("Reference Error: unknown reference used -> %s", referenceName)
        );
    }

    public ValidationResult emptyField() {
        return ValidationResult.error(
                "rule.ref.empty-field",
                "Reference Error: field cannot have empty segments"
        );
    }

    public ValidationResult nonCollectionField(String reference, String path) {
        return ValidationResult.error(
                "rule.ref.non-collection-field",
                String.format("Reference Error: field is not collection type -> %s.%s", reference, path)
        );
    }

    public ValidationResult unknownField(String reference, String path) {
        return ValidationResult.error(
                "rule.ref.unknown-field",
                String.format("Reference Error: unknown field used -> %s.%s", reference, path)
        );
    }

    public ValidationResult multipleCollectionMarkers(String reference, String path) {
        return ValidationResult.warning(
                "rule.ref.multiple-collection-markers",
                String.format("Reference Error: field has more than one collection marker -> %s.%s", reference, path)
        );
    }
}
