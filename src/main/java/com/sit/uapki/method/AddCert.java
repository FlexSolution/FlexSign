/*
 * Copyright (c) 2021, The UAPKI Project Authors.
 * 
 * Redistribution and use in source and binary forms, with or without 
 * modification, are permitted provided that the following conditions are 
 * met:
 * 
 * 1. Redistributions of source code must retain the above copyright 
 * notice, this list of conditions and the following disclaimer.
 * 
 * 2. Redistributions in binary form must reproduce the above copyright 
 * notice, this list of conditions and the following disclaimer in the 
 * documentation and/or other materials provided with the distribution.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS 
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED 
 * TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A 
 * PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT 
 * HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, 
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED 
 * TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR 
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF 
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING 
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS 
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.sit.uapki.method;

import com.sit.uapki.cert.CertId;
import com.sit.uapki.common.PkiData;

import java.util.ArrayList;
import java.util.List;

/**
 * Classes for ADD_CERT-method
 */
public interface AddCert {
    static final String METHOD = "ADD_CERT";

    class Parameters {
        final String bundle;
        final ArrayList<String> certificates;
        final boolean permanent;

        public Parameters (List<PkiData> certificates, boolean permanent) {
            this.bundle = null;
            this.certificates = new ArrayList<>();
            for (int i = 0; i < certificates.size(); i++) {
                this.certificates.add(certificates.get(i).toString());
            }
            this.permanent = permanent;
        }

        public Parameters (PkiData bundle, boolean permanent) {
            this.bundle = bundle.toString();
            this.certificates = null;
            this.permanent = permanent;
        }
    }   //  end class Parameters

    public class AddedCertInfo {
        private String certId;
        private boolean isUnique;

        public CertId getCertId () {
            return new CertId(this.certId);
        }

        public boolean isUnique () {
            return this.isUnique;
        }
    }   //  end class AddedCertInfo

    class Result {
        ArrayList<AddedCertInfo> added;

        public ArrayList<AddedCertInfo> getAdded () {
            return this.added;
        }
    }   //  end class Result

}
