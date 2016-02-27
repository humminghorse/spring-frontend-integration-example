STATIC_DIR = ../todo-app/src/main/resources/static

all: clean $(STATIC_DIR)/bundle.js

$(STATIC_DIR)/bundle.js: node_modules $(STATIC_DIR)
	@node_modules/.bin/browserify scripts/main.js -o $@

watch-js: node_modules $(STATIC_DIR)
	@node_modules/.bin/watchify scripts/main.js -o $(STATIC_DIR)/bundle.js -v

$(STATIC_DIR):
	@mkdir -p $@

clean:
	@rm -rf $(STATIC_DIR)

node_modules: package.json
	@npm install

.PHONY: all watch-js clean
