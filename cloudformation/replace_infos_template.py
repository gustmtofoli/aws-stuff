value = "lambda_arn_here"

with open('create_endpoint_apig.yaml', 'rt') as file_in:
    with open('template_create_endpoint_apig.yaml', 'wt') as file_out:
        for line in file_in:
            file_out.write(line.replace('#lambda_arn', value))