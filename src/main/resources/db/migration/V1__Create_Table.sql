CREATE TABLE IF NOT EXISTS sherlock.sherlock_request (
    id BIGINT AUTO_INCREMENT,
    lead_id VARCHAR(255),
    customer_id VARCHAR(255),
    case_id VARCHAR(255) UNIQUE,
    raw_json JSON,
    sherlock_request_data TEXT,
    acknowledgement_xml TEXT,
    created_on TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    update_on TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    create_by VARCHAR(255),
    modified_by VARCHAR(255),
    version INT DEFAULT 0,
    PRIMARY KEY (id),
    UNIQUE KEY (case_id),
    INDEX idx_sher_req_lead_id (lead_id, customer_id),
    INDEX idx_req_case_id (case_id)
);

CREATE TABLE IF NOT EXISTS sherlock.id_data (
    id_data BIGINT AUTO_INCREMENT,
    passport_number VARCHAR(255),
    voter_id VARCHAR(255),
    uid VARCHAR(255),
    ration_card_number VARCHAR(255),
    driving_license_number VARCHAR(255),
    pan VARCHAR(255),
    nrega_card_number VARCHAR(255),
    ckyc VARCHAR(255),
    other VARCHAR(255),
    sherlock_request_fk BIGINT,
    created_on TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    update_on TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    create_by VARCHAR(255),
    modified_by VARCHAR(255),
    version INT DEFAULT 0,
    PRIMARY KEY (id_data),
    FOREIGN KEY (sherlock_request_fk) REFERENCES sherlock.sherlock_request(id)
);

CREATE TABLE sherlock.sherlock_response (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    lead_id VARCHAR(255),
    customer_id VARCHAR(255),
    xml_report TEXT,
    html_report TEXT,
    status VARCHAR(255),
    score VARCHAR(255),
    case_id VARCHAR(255) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT fk_case_id FOREIGN KEY (case_id) REFERENCES sherlock.sherlock_request(case_id),
    INDEX idx_sher_res_lead_id (lead_id, customer_id),
    INDEX idx_res_case_id (case_id)
);

